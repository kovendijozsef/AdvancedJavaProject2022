package org.ppke.itk.formula1.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.Resource;

@Controller
public class ImageController {
    @GetMapping(
            value = "/getLogo",
            produces = "image/svg+xml"
    )
    public @ResponseBody byte[] getLogo() throws IOException {
        Resource resource = new ClassPathResource("f1-tv-logo.svg");

        return IOUtils.toByteArray(resource.getInputStream());
    }
}
