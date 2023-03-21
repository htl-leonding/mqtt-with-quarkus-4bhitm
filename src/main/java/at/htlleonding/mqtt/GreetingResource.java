package at.htlleonding.mqtt;

import at.htlleonding.mqtt.outgoing.MqttPressurePublisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/send")
public class GreetingResource {

    @Inject
    MqttPressurePublisher mqttPressurePublisher;

    @GET
    @Path("{value}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("value") String value) {
        mqttPressurePublisher.send(value);
        return "Pressure sent " + value;
    }
}