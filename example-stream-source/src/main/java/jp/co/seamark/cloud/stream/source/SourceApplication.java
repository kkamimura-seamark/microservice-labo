package jp.co.seamark.cloud.stream.source;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.seamark.cloud.stream.bean.DemoBean;

@SpringBootApplication
@EnableBinding({Source.class,MapSource.class,BeanSource.class})
@RestController
public class SourceApplication {

	@Autowired
	private Source source;
	@Autowired
	private MapSource mapSource;
	@Autowired
	private BeanSource beanSource;
	
	@PostMapping(path="message")
	public void send(@RequestBody String message){
		source.output().send(MessageBuilder.withPayload(message).build());
	}
	
	@PostMapping("map")
	public void send(@RequestParam String val1,@RequestParam String val2){
		Map<String, Object> values = new HashMap<>();
		values.put("val1", val1);
		values.put("val2", val2);
		values.put("val3", new Date());
		mapSource.output().send(MessageBuilder.withPayload(values).build());
	}
	
	@PostMapping("bean")
	public void send(@RequestParam String name,@RequestParam String description ,@RequestParam String decimalValue){
		DemoBean values = new DemoBean(name, description, new Date(), new BigDecimal(decimalValue));
		beanSource.output().send(MessageBuilder.withPayload(values).build());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SourceApplication.class, args);
	}
}
