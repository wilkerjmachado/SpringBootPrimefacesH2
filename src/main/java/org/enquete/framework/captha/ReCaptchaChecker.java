package org.enquete.framework.captha;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class ReCaptchaChecker {

	public static final String RECAPTCHA_VERIF_URL = "https://www.google.com/recaptcha/api/siteverify";
	
	public static final String RECAPTCHA_SECRET = "6Lcq0goTAAAAAKOxVyBOdRfZRcUSM23aFJtP13MX";
	 
    public static ReCaptchaCheckerReponse checkReCaptcha(String response) {
    	
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        
        map.add("secret", RECAPTCHA_SECRET);
        map.add("response", response);
 
        RestTemplate restTemplate = new RestTemplate();
 
        return restTemplate.postForObject(RECAPTCHA_VERIF_URL, map, ReCaptchaCheckerReponse.class);
    }
}
