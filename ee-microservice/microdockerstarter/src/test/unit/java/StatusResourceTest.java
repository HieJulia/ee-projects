import icoder.config.Config;
import icoder.models.Service;
import icoder.resources.StatusResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Unit test - Mockito
 */
@RunWith(MockitoJUnitRunner.class)
public class StatusResourceTest {


  @Mock
  Config config;

  @InjectMocks
  StatusResource statusResource;




  // Test 1 
  @Test
  public void t1Status() {
    when(config.toString("applicationName")).thenReturn("starter-kit");
    when(config.toString("version")).thenReturn("1.0.0");
    when(config.toString("environment")).thenReturn("test");

    Service service = new Service();
    service.setMessage("Service is up and running");
    service.setName(config.toString("applicationName"));
    service.setVersion(config.toString("version") + ":" + config.toString("environment"));

    //  assert equal 
    assertEquals(statusResource.status(), service);
  }


  // Test 2
  @Test
  public void t2Status(){

    Service service = new Service();
    service.setMessage("Service is up and running");
    service.setName(config.toString("applicationName"));
    service.setVersion(config.toString("version") + ":" + config.toString("environment"));

    // Assert not null 
    assertNotNull(service);
  }




}