package integration;

import geocoding.TqsBasicHttpClient;
import geocoding.Address;
import geocoding.AddressResolver;
import geocoding.ISimpleHttpClient;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AddressResolverIT {
    private AddressResolver addressResolver;


    @BeforeEach
    public void init(){
        this.addressResolver = new AddressResolver(new TqsBasicHttpClient());   
    }

    @Test
    public void whenGoodCoordidates_returnAddress() throws IOException, URISyntaxException, ParseException {

        double lat = 40.6318;
        double lon = -8.658;


        Optional<Address> answr = addressResolver.findAddressForLocation(lat,lon);

        assertTrue(answr.isPresent());
        Address addr = answr.get();

        assertTrue(addr.getRoad().equals("Parque Estacionamento da Reitoria - Univerisdade de Aveiro"));
        assertTrue(addr.getCirty().equals("Glória e Vera Cruz"));
        assertTrue(addr.getState().equals("Centro"));
        assertFalse(addr.getZio().equals("3810-100"));
        assertNull(addr.getHouseNumber());

    }

    @Test
    public void whenBadCoordidates_thenReturnNoValidAddrress() throws IOException, URISyntaxException, ParseException {

        assertFalse(addressResolver.findAddressForLocation(-300, -810).isPresent());
        assertFalse(addressResolver.findAddressForLocation(40, -200).isPresent());
        assertFalse(addressResolver.findAddressForLocation(40, 200).isPresent());
        assertFalse(addressResolver.findAddressForLocation(-100, 75).isPresent());
        assertFalse(addressResolver.findAddressForLocation(100, 75).isPresent());
        
    }

}
