package com.olliniinioja.demo.yle.TeleText.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return """
                Usage: /v1/{page}/{subpage}.png?app_id=[id]&app_key=[key]&time=[epoch]
                <br />
                <br />
                Required params: app_id, app_key
                <br />
                Optional params: time
                <br />
                <br />
                Test cases:
                <br />
                <h2>2010-01-01T00:00:00.000Z</h2><br />
                <a target="_blank" href="/v1/100/1.png?app_id=teletext&app_key=secret&time=1493431347">/v1/100/1.png?app_id=teletext&app_key=secret&time=1493431347</a>
                <br />
                <a target="_blank" href="/v1/100/2.png?app_id=teletext&app_key=secret&time=1493431347">/v1/100/2.png?app_id=teletext&app_key=secret&time=1493431347</a>
                <br />
                <a target="_blank" href="/v1/100/3.png?app_id=teletext&app_key=secret&time=1493431347">/v1/100/3.png?app_id=teletext&app_key=secret&time=1493431347</a>
                <br />
                <a target="_blank" href="/v1/100/4.png?app_id=teletext&app_key=secret&time=1493431347">/v1/100/4.png?app_id=teletext&app_key=secret&time=1493431347</a>
                <br />
                <h2>2020-01-01T00:00:00.000Z</h2><br />
                <a target="_blank" href="/v1/100/1.png?app_id=teletext&app_key=secret&time=1593431347">/v1/100/1.png?app_id=teletext&app_key=secret&time=1593431347</a>
                <br />
                <a target="_blank" href="/v1/100/2.png?app_id=teletext&app_key=secret&time=1593431347">/v1/100/2.png?app_id=teletext&app_key=secret&time=1593431347</a>
                <br />
                <a target="_blank" href="/v1/100/3.png?app_id=teletext&app_key=secret&time=1593431347">/v1/100/3.png?app_id=teletext&app_key=secret&time=1593431347</a>
                <br />
                <a target="_blank" href="/v1/100/4.png?app_id=teletext&app_key=secret&time=1593431347">/v1/100/4.png?app_id=teletext&app_key=secret&time=1593431347</a>
                <br />
                <h2>2023-08-30T20:00:00.000Z</h2><br />
                <a target="_blank" href="/v1/100/1.png?app_id=teletext&app_key=secret&time=1693431347">/v1/100/1.png?app_id=teletext&app_key=secret&time=1693431347</a>
                <br />
                <a target="_blank" href="/v1/100/2.png?app_id=teletext&app_key=secret&time=1693431347">/v1/100/2.png?app_id=teletext&app_key=secret&time=1693431347</a>
                <br />
                <a target="_blank" href="/v1/100/3.png?app_id=teletext&app_key=secret&time=1693431347">/v1/100/3.png?app_id=teletext&app_key=secret&time=1693431347</a>
                <br />
                <a target="_blank" href="/v1/100/4.png?app_id=teletext&app_key=secret&time=1693431347">/v1/100/4.png?app_id=teletext&app_key=secret&time=1693431347</a>
                <br />
                <h2>latest, same as 2023-08-30T20:00:00.000Z</h2><br />
                <a target="_blank" href="/v1/100/1.png?app_id=teletext&app_key=secret">/v1/100/1.png?app_id=teletext&app_key=secret</a>
                <br />
                <a target="_blank" href="/v1/100/2.png?app_id=teletext&app_key=secret">/v1/100/2.png?app_id=teletext&app_key=secret</a>
                <br />
                <a target="_blank" href="/v1/100/3.png?app_id=teletext&app_key=secret">/v1/100/3.png?app_id=teletext&app_key=secret</a>
                <br />
                <a target="_blank" href="/v1/100/4.png?app_id=teletext&app_key=secret">/v1/100/4.png?app_id=teletext&app_key=secret</a>
                <br />
                """;
    }
}
