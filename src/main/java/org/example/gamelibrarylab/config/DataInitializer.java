package org.example.gamelibrarylab.config;

import org.example.gamelibrarylab.entity.Game;
import org.example.gamelibrarylab.repository.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("dev")
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(GameRepository repository) {
        return _ -> {
            Game zelda = new Game();
            zelda.setTitle("The Legend of Zelda: Breath of the Wild");
            zelda.setDescription("An open-world action-adventure game where players explore the kingdom of Hyrule.");
            zelda.setReleaseDate(LocalDate.of(2017, 3, 3));
            zelda.setDeveloper("Nintendo EPD");
            zelda.setPublisher("Nintendo");
            repository.save(zelda);

            Game eldenRing = new Game();
            eldenRing.setTitle("Elden Ring");
            eldenRing.setDescription("An action RPG developed by FromSoftware featuring a vast open world and challenging combat.");
            eldenRing.setReleaseDate(LocalDate.of(2022, 2, 25));
            eldenRing.setDeveloper("FromSoftware");
            eldenRing.setPublisher("Bandai Namco Entertainment");
            repository.save(eldenRing);

            Game mario = new Game();
            mario.setTitle("Super Mario Odyssey");
            mario.setDescription("A platform game where Mario explores various kingdoms using a hat named Cappy.");
            mario.setReleaseDate(LocalDate.of(2017, 10, 27));
            mario.setDeveloper("Nintendo EPD");
            mario.setPublisher("Nintendo");
            repository.save(mario);

            Game witcher = new Game();
            witcher.setTitle("The Witcher 3: Wild Hunt");
            witcher.setDescription("An open-world RPG where you play as Geralt of Rivia, a monster hunter.");
            witcher.setReleaseDate(LocalDate.of(2015, 5, 19));
            witcher.setDeveloper("CD Projekt Red");
            witcher.setPublisher("CD Projekt");
            repository.save(witcher);

            Game minecraft = new Game();
            minecraft.setTitle("Minecraft");
            minecraft.setDescription("A sandbox game that allows players to build and destroy various types of blocks in a 3D world.");
            minecraft.setReleaseDate(LocalDate.of(2011, 11, 18));
            minecraft.setDeveloper("Mojang Studios");
            minecraft.setPublisher("Mojang Studios");
            repository.save(minecraft);

            Game gow = new Game();
            gow.setTitle("God of War Ragnarök");
            gow.setDescription("An action-adventure game continuing the story of Kratos and Atreus in Norse mythology.");
            gow.setReleaseDate(LocalDate.of(2022, 11, 9));
            gow.setDeveloper("Santa Monica Studio");
            gow.setPublisher("Sony Interactive Entertainment");
            repository.save(gow);

            Game rdr2 = new Game();
            rdr2.setTitle("Red Dead Redemption 2");
            rdr2.setDescription("An action-adventure game set in the American Wild West.");
            rdr2.setReleaseDate(LocalDate.of(2018, 10, 26));
            rdr2.setDeveloper("Rockstar Studios");
            rdr2.setPublisher("Rockstar Games");
            repository.save(rdr2);

            Game hollowKnight = new Game();
            hollowKnight.setTitle("Hollow Knight");
            hollowKnight.setDescription("A 2D Metroidvania action-adventure game where the player explores the insect kingdom of Hallownest.");
            hollowKnight.setReleaseDate(LocalDate.of(2017, 2, 24));
            hollowKnight.setDeveloper("Team Cherry");
            hollowKnight.setPublisher("Team Cherry");
            repository.save(hollowKnight);

            Game portal2 = new Game();
            portal2.setTitle("Portal 2");
            portal2.setDescription("A puzzle-platform game where players use portals to solve challenges.");
            portal2.setReleaseDate(LocalDate.of(2011, 4, 19));
            portal2.setDeveloper("Valve Corporation");
            portal2.setPublisher("Valve Corporation");
            repository.save(portal2);

            Game celeste = new Game();
            celeste.setTitle("Celeste");
            celeste.setDescription("A platform game about a young woman named Madeline who climbs a mountain.");
            celeste.setReleaseDate(LocalDate.of(2018, 1, 25));
            celeste.setDeveloper("Maddy Makes Games");
            celeste.setPublisher("Maddy Makes Games");
            repository.save(celeste);

            Game darkSouls = new Game();
            darkSouls.setTitle("Dark Souls III");
            darkSouls.setDescription("An action RPG known for its challenging gameplay and dark fantasy setting.");
            darkSouls.setReleaseDate(LocalDate.of(2016, 3, 24));
            darkSouls.setDeveloper("FromSoftware");
            darkSouls.setPublisher("Bandai Namco Entertainment");
            repository.save(darkSouls);

            Game stardew = new Game();
            stardew.setTitle("Stardew Valley");
            stardew.setDescription("A farming simulation game where players restore their grandfather's farm.");
            stardew.setReleaseDate(LocalDate.of(2016, 2, 26));
            stardew.setDeveloper("ConcernedApe");
            stardew.setPublisher("ConcernedApe");
            repository.save(stardew);

            Game animalCrossing = new Game();
            animalCrossing.setTitle("Animal Crossing: New Horizons");
            animalCrossing.setDescription("A social simulation game where players live on a deserted island.");
            animalCrossing.setReleaseDate(LocalDate.of(2020, 3, 20));
            animalCrossing.setDeveloper("Nintendo EPD");
            animalCrossing.setPublisher("Nintendo");
            repository.save(animalCrossing);

            Game hades = new Game();
            hades.setTitle("Hades");
            hades.setDescription("A roguelike action game where Zagreus attempts to escape the Underworld.");
            hades.setReleaseDate(LocalDate.of(2020, 9, 17));
            hades.setDeveloper("Supergiant Games");
            hades.setPublisher("Supergiant Games");
            repository.save(hades);

            Game sekiro = new Game();
            sekiro.setTitle("Sekiro: Shadows Die Twice");
            sekiro.setDescription("An action-adventure game set in Sengoku period Japan.");
            sekiro.setReleaseDate(LocalDate.of(2019, 3, 22));
            sekiro.setDeveloper("FromSoftware");
            sekiro.setPublisher("Activision");
            repository.save(sekiro);

            System.out.println("✅ Dev database seeded with " + repository.count() + " games!");
        };
    }
}
