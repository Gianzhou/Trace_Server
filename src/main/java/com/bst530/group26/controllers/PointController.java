package com.bst530.group26.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bst530.group26.repositories.PointRepository;

@Controller
public class PointController {
    @Autowired
    private PointRepository pointRepository;
}
