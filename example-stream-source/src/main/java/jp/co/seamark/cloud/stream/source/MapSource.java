package jp.co.seamark.cloud.stream.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MapSource {

	@Output("mapoutput")
	MessageChannel output();
}
