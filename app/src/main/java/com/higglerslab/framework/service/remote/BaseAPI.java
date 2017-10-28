package com.higglerslab.framework.service.remote;


import com.higglerslab.framework.MyApplication;
import com.higglerslab.framework.service.events.BaseEvent;
import com.higglerslab.framework.service.events.EmptyEvent;
import com.higglerslab.framework.service.events.ErrorEvent;
import com.higglerslab.framework.util.constants.I;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Response;

/**
 * Created by dvadivel
 */

abstract class BaseAPI {
    MyApplication app = MyApplication.getInstance();

    EventBus event = EventBus.getDefault();

    EmptyEvent mEmptyEvent = new EmptyEvent();

    void handleResponse(Response response, BaseEvent eventClass) {
        if (response.isSuccessful()) {
            if (response.code() == I.HTTP_NO_CONTENT) {
                event.post(mEmptyEvent);
            } else {
                event.post(eventClass);
            }
        } else {
            event.post(new ErrorEvent(response));
        }
    }
}
