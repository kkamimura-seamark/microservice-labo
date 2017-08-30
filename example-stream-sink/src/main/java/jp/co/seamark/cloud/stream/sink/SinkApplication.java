package jp.co.seamark.cloud.stream.sink;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import jp.co.seamark.cloud.stream.bean.DemoBean;

@SpringBootApplication
@EnableBinding({Sink.class,MapSink.class,BeanSink.class})
public class SinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinkApplication.class, args);
	}
	
	@StreamListener(Sink.INPUT)
	public void println(String message){
		System.out.println(message);
	}
	
	@StreamListener(MapSink.INPUT)
	public void println(Map<String, Object> values){
		System.out.println(values);
		System.out.println(values.get("val1"));
		System.out.println(values.get("val2"));
		System.out.println(values.get("val3"));
	}
	@StreamListener(BeanSink.INPUT)
	public void demoListener(DemoBean value){
		System.out.println(value);
		System.out.println(value.getName());
		System.out.println(value.getDescription());
		System.out.println(value.getCreatedAt());
		System.out.println(value.getDecimalValue());
	}
}
