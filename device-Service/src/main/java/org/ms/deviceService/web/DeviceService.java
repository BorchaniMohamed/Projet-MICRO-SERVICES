package org.ms.deviceService.web;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@CrossOrigin("http://localhost:4200")
public class DeviceService {

    @GetMapping("/deviceDinarsEuro/{devise}/{amount}")
    @ResponseBody
    private String finddinarsdevice(@PathVariable String devise,@PathVariable String amount) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/fixer/convert?to="+devise+"&from=TND&amount="+amount)
                .addHeader("apikey", "C1G1EtJ8pfCBaRHLFr2TdvrsOrtjxNtl")
                .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
    }
}
