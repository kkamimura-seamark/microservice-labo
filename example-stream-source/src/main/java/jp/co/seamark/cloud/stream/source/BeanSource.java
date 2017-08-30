package jp.co.seamark.cloud.stream.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BeanSource {
	String OUTPUT="beanoutput";

	@Output(BeanSource.OUTPUT)
	MessageChannel output();
}
