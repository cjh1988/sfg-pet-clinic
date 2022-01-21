package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(dog);

        Owner owner1 = new Owner();

        owner1.setFirstName("Christian");
        owner1.setLastName("JHirache");
        owner1.setAddress("Calle 2 633 4E");
        owner1.setCity("La Plata");
        owner1.setTelephone("2213445464");
        ownerService.save(owner1);

        Pet chrisPets = new Pet();
        chrisPets.setPetType(saveDogPetType);
        chrisPets.setOwner(owner1);
        chrisPets.setBirthDate(LocalDate.now());
        chrisPets.setName("Natsu");
        owner1.getPets().add(chrisPets);

        Owner owner2 = new Owner();

        owner2.setFirstName("Milu");
        owner2.setLastName("JHirache");
        owner1.setAddress("Calle 2 633 4E");
        owner1.setCity("La Plata");
        owner1.setTelephone("2213448793");
        ownerService.save(owner2);

        Pet miluPets = new Pet();
        miluPets.setPetType(saveCatPetType);
        miluPets.setOwner(owner2);
        miluPets.setBirthDate(LocalDate.now());
        miluPets.setName("Felina");
        owner2.getPets().add(miluPets);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();

        vet1.setFirstName("Kassandra");
        vet1.setLastName("JHirache");
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Leonardo");
        vet2.setLastName("JHirache");
        vetService.save(vet2);

        System.out.println("Loaded Vets.....");

    }
}
