package utils;

import java.util.Map;

/**
 * Created by kunal on 26/11/17.
 */
public class StringUtils {
    public static String replaceTag(String tagName, String value ,String srcString){
        return srcString.replace("{" + tagName + "}",  value);
    }

    public static String replaceTags(Map<String, String> tags, String srcString){
        for(String tag: tags.keySet()){
            srcString = replaceTag(tag, tags.get(tag), srcString);
        }
        return srcString;
    }
}
