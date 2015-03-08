package me.rbrickis.aurora.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Ryan on 3/6/2015
 * <p/>
 * Project: Aurora
 *
 * Represents an Header in a Request/Response
 */
@Getter
@AllArgsConstructor
public class Header {
    String key;
    String value;
}
