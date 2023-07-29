package demo.sftp;

import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jcraft.jsch.ChannelSftp.LsEntry;

public class SftpTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		SftpFileTransferService sftpService = new SftpFileTransferService();
		
		String readFileDirPath = "/home/administrator/Panchatantra/BBPS/SETTLEMENT/";
		
		Vector<LsEntry> allFilesByPath = sftpService.getAllFilesByPath(readFileDirPath);
		Vector<LsEntry> jsonFiles = allFilesByPath.stream()
												.filter(entry -> entry.getFilename().contains(".json"))
												.collect(Collectors.toCollection(Vector::new));
		
		try
		{
			for(LsEntry entry : jsonFiles) {
				String content = sftpService.readRemoteFileContent(readFileDirPath+entry.getFilename());
				
				JSONArray dataArr = new JSONArray(content);
				for(int index=0; index < dataArr.length(); index++) {
					JSONObject txtObj = dataArr.getJSONObject(index);
					String txtAmount = txtObj.getString("transaction_amount");
					BigDecimal amount = new BigDecimal(txtAmount);
				}
				System.out.println("***** " + entry.getFilename());
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Outer Exception");
		}
	}
}
