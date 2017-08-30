package jp.co.seamark.cloud.stream.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MapSink {
	String INPUT="mapinput";
	@Input(MapSink.INPUT)
	SubscribableChannel input();
}
