package com.acmvit.acm_app.util;

import com.acmvit.acm_app.model.Notification;
import com.acmvit.acm_app.model.Request;
import java.util.Arrays;
import java.util.List;

public class MockData {

  public static final List<String> icons = Arrays.asList(
    "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
    "data:image/jpeg;base64,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",
    "data:image/jpeg;base64,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"
  );

  public static final List<Notification> notifications = Arrays.asList(
    new Notification(icons.get(0), "You are invited to join project xyz"),
    new Notification(icons.get(1), "Gokul has completed project pqr"),
    new Notification(icons.get(2), "Amit has joined project abc")
  );

  public static final List<Request> requests = Arrays.asList(
    new Request(icons.get(0), "Amit Krishna A", "xyz"),
    new Request(icons.get(1), "Gokul Kurup", "pqr"),
    new Request(icons.get(2), "Sreyas", "abc")
  );
}
