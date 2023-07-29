package demo.sftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

import org.apache.commons.io.IOUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SftpFileTransferService {
	
	private String host = "192.168.1.249";
	private Integer port = 22;
	private String username = "administrator";
	private String password = "admin";
	
	// Create SFTP Channel
	private ChannelSftp createChannelSftp() throws JSchException {
		try {
			JSch jSch = new JSch();
			Session session = jSch.getSession(username, host, port);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();
			Channel channel = session.openChannel("sftp");
			channel.connect();
			return (ChannelSftp) channel;
		} catch(JSchException ex) {
			ex.printStackTrace();
		}
		
		throw new JSchException("Error while opening SFTP Channel.");
	}
	
	// Disconnect SFTP Channel
	private void disconnectChannelSftp(ChannelSftp channelSftp) {
		try {
			if( channelSftp == null) 
				return;
			
			if(channelSftp.isConnected()) 
				channelSftp.disconnect();
			
			if(channelSftp.getSession() != null) 
				channelSftp.getSession().disconnect();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// Upload file from local path to remote path
	public boolean uploadFileWithSourceToDestination(String localFilePath, String remoteFilePath) throws JSchException {
		ChannelSftp channelSftp = createChannelSftp();
		try {
			channelSftp.put(localFilePath, remoteFilePath);
			return true;
		} catch(SftpException ex) {
			ex.printStackTrace();
		} finally {
			disconnectChannelSftp(channelSftp);
		}
		
		return false;
	}
	
	// Upload file to remote path
	public OutputStream uploadFileToDestination(String remoteFilePath) throws JSchException {
		ChannelSftp channelSftp = createChannelSftp();
		try {
			return channelSftp.put(remoteFilePath);
		} catch(SftpException ex) {
			ex.printStackTrace();
		} finally {
			disconnectChannelSftp(channelSftp);
		}
		
		return null;
	}
	
	// Remove file from remote
	public boolean removeFile(String remoteFilePath) throws JSchException {
		ChannelSftp channelSftp = createChannelSftp();
		try {
			channelSftp.rm(remoteFilePath);
			return true;
		} catch(SftpException ex) {
			ex.printStackTrace();
		} finally {
			disconnectChannelSftp(channelSftp);
		}
		
		return false;
	}

	// Download file from remote path to local path and remove from remote
	public boolean downloadFileAndRemoveFromRemote(String localFilePath, String remoteFilePath) throws IOException, JSchException {
		ChannelSftp channelSftp = createChannelSftp();
		File file = new File(localFilePath);
		try(OutputStream outputStream = new FileOutputStream(file);) 
		{
			channelSftp.get(remoteFilePath, outputStream);
			channelSftp.rm(remoteFilePath);
			return !file.createNewFile();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnectChannelSftp(channelSftp);
		}
		
		return false;
	}
	
	// Download file from remote path to local path 
	public boolean downloadFile(String localFilePath, String remoteFilePath) throws JSchException {
		ChannelSftp channelSftp = createChannelSftp();
		try {
			File file = new File(localFilePath);
			channelSftp.get(remoteFilePath, localFilePath);
			return !file.createNewFile();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnectChannelSftp(channelSftp);
		}
		
		return false;
	}

	// Move file
	public boolean moveFile(String soruceFilePath, String desFilePath) throws JSchException {
		ChannelSftp channelSftp = createChannelSftp();
		try {
			channelSftp.rename(soruceFilePath, desFilePath);
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnectChannelSftp(channelSftp);
		}
		
		return false;
	}
	
	// Get all files
	@SuppressWarnings("unchecked")
	public  Vector<ChannelSftp.LsEntry> getAllFilesByPath(String pathName) throws Exception{
		ChannelSftp channelSftp = createChannelSftp();
		channelSftp.cd(pathName);
		Vector<ChannelSftp.LsEntry> list = null;
		
		try {
			list = channelSftp.ls(pathName);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disconnectChannelSftp(channelSftp);
		}
		
		return list;
	}
	
	// Read remote file content
	public String readRemoteFileContent(String remoteFilePath) throws JSchException {
		ChannelSftp channelSftp = createChannelSftp();
		String content = "";
		try {
			InputStream inputStream = channelSftp.get(remoteFilePath);
			content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new JSchException("Error while reading content from file!", ex);
		} finally {
			disconnectChannelSftp(channelSftp);
		}
		
		return content;
	}
}
