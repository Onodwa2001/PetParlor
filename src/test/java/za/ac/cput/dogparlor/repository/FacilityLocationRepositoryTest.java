package za.ac.cput.dogparlor.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.dogparlor.domain.FacilityLocation;
import za.ac.cput.dogparlor.domain.Location;
import za.ac.cput.dogparlor.factory.FacilityLocationFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class FacilityLocationRepositoryTest {

    private static final FacilityLocationRepository repository = FacilityLocationRepository.getFacilityLocationRepository();
    private static final FacilityLocation facilityLocation = FacilityLocationFactory.createFacilityLocation(1232, 4424);

    @Test
    void a_create() {
        FacilityLocation facilityLocation1 = repository.create(facilityLocation); // created
        System.out.println(facilityLocation1);
        assertEquals(facilityLocation, facilityLocation1);
    }

    @Test
    void b_read() {
        FacilityLocation retrievedFacilityLocation = repository.read(facilityLocation.getFacilityID());
        System.out.println(retrievedFacilityLocation);
        assertNotNull(retrievedFacilityLocation);
    }

    @Test
    void c_update() {
        FacilityLocation updated = new FacilityLocation.FacilityLocationBuilder()
                .setLocationID(1234)
                .setFacilityID(5543)
                .build();

        System.out.println(updated);
        assertNotNull(repository.update(updated));
    }

    @Test
    void e_delete() {
        FacilityLocation deleted = repository.delete(facilityLocation);
        System.out.println(deleted);
        assertNotNull(deleted);

    }

    @Test
    void d_getAllFacilityLocations() {
        Set<FacilityLocation> facilityLocationSet = repository.getAllFacilityLocations();
        System.out.println(facilityLocationSet);
        assertNotNull(facilityLocationSet);
    }

}