package pl.wojciech.springcloudclient3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogMessage implements Serializable {

    private static final long SERIAL_VERSION_UID = -5857383701708275796L;

    private String message;

}
