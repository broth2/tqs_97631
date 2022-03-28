package geocoding;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.beans.Transient;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

/*
    b)

    Subject Under Test (SuT): AddressResolver

    Service to mock: ISimpleHttpClient

*/

@ExtendWith(MockitoExtension.class)
public class AddressResolverTest {

    @Mock
    private ISimpleHttpClient simpleHttpClient;

    @InjectMocks
    private AddressResolver addressResolver;


    @Test
    void whenResolveAlboiGps_returnCaisAlboiAddress() throws ParseException, IOException, URISyntaxException {

        //done below

    }

    @Test
    public void whenBadCoordidates_thenReturnNoValidAddress() throws IOException, URISyntaxException, ParseException {
        
        assertFalse(addressResolver.findAddressForLocation(-300, -810).isPresent());
        assertFalse(addressResolver.findAddressForLocation(40, -200).isPresent());
        assertFalse(addressResolver.findAddressForLocation(40, 200).isPresent());
        assertFalse(addressResolver.findAddressForLocation(-100, 75).isPresent());
        assertFalse(addressResolver.findAddressForLocation(100, 75).isPresent());

    }

    @Test 
    public void simpleFindAddressForLocationTest()throws RuntimeException, ParseException, URISyntaxException, IOException {
        String request_url = "http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=40.631800%2C-8.658000&includeRoadMetadata=true";
        String response = "{`info`:{`statuscode`:0,`copyright`:{`text`:`\u00A9 2022 MapQuest, Inc.`,`imageUrl`:`http://api.mqcdn.com/res/mqlogo.gif`,`imageAltText`:`\u00A9 2022 MapQuest, Inc.`},`messages`:[]},`options`:{`maxResults`:1,`thumbMaps`:true,`ignoreLatLngInput`:false},`results`:[{`providedLocation`:{`latLng`:{`lat`:40.6318,`lng`:-8.658}},`locations`:[{`street`:`Parque Estacionamento da Reitoria - Univerisdade de Aveiro`,`adminArea6`:``,`adminArea6Type`:`Neighborhood`,`adminArea5`:`Gl\u00F3ria e Vera Cruz`,`adminArea5Type`:`City`,`adminArea4`:``,`adminArea4Type`:`County`,`adminArea3`:`Centro`,`adminArea3Type`:`State`,`adminArea1`:`PT`,`adminArea1Type`:`Country`,`postalCode`:`3810-193`,`geocodeQualityCode`:`P1AAA`,`geocodeQuality`:`POINT`,`dragPoint`:false,`sideOfStreet`:`N`,`linkId`:`0`,`unknownInput`:``,`type`:`s`,`latLng`:{`lat`:40.631803,`lng`:-8.657881},`displayLatLng`:{`lat`:40.631803,`lng`:-8.657881},`mapUrl`:`http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.6318025,-8.657881|marker-sm-50318A-1&scalebar=true&zoom=15&rand=1123609733`,`roadMetadata`:null}]}]}".replace('`', '"');
        
        double lat = 40.6318;
        double lon = -8.658;

        //stub
        when(simpleHttpClient.doHttpGet(request_url)).thenReturn(response);

        Optional<Address> answr = addressResolver.findAddressForLocation(lat,lon);

        assertTrue(answr.isPresent());
        Address addr = answr.get();

        String road = addr.getRoad();
        String city = addr.getCirty();
        String state = addr.getState();
        String zip = addr.getZio();
        String num = addr.getHouseNumber();

        assertTrue(road.equals("Parque Estacionamento da Reitoria - Univerisdade de Aveiro"));
        assertTrue(city.equals("Glória e Vera Cruz"));
        assertTrue(state.equals("Centro"));
        assertTrue(zip.equals("3810-193"));
        assertNull(num);




    }
}