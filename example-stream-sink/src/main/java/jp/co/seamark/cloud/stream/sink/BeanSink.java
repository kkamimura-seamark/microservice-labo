package jp.co.seamark.cloud.stream.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface BeanSink {

	String INPUT="beaninput";
	
	@Input(BeanSink.INPUT)
	SubscribableChannel input();
}
