package demo.java8;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class LocalDateTimeJsonDemo {
	
	public static void main(String args[])
	{
		CustomDto dto = new CustomDto();
		dto.setDateTime(LocalDateTime.now());;
		System.out.println(dto);
		
		// Convert dto to json
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
				.create();
		String json = gson.toJson(dto);
		System.out.println(json);
		
		// parse json to dto
		CustomDto parsedDto = gson.fromJson(json, CustomDto.class);
		System.out.println(parsedDto);
	}
}

class CustomDto {
	private LocalDateTime dateTime;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "CustomDto [dateTime=" + dateTime + "]";
	}
}

class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSSSSSSSS");
	
	@Override
	public LocalDateTime read(JsonReader reader) throws IOException {
		if(reader.peek() == JsonToken.NULL) {
			reader.nextNull();
			return null;
		} else {
			return LocalDateTime.parse(reader.nextString(), formatter);
		}
	}

	@Override
	public void write(JsonWriter writer, LocalDateTime dateTime) throws IOException {
		if(dateTime == null) {
			writer.nullValue();
		} else {
			writer.value(formatter.format(dateTime));
		}
	}
}