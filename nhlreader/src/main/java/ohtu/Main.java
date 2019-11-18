/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author mluukkai
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        LocalDateTime dateObj = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        
        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        System.out.println("Oliot:");
        for (Player player : players) {
            System.out.println(player);
        }
        System.out.println("\nPlayers from FIN " + dateObj.format(dateFormat) + ":\n");
        List<Player> finnishPlayers = new ArrayList<Player>();
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                finnishPlayers.add(player);
            }
        }
        Collections.sort(finnishPlayers, Collections.reverseOrder());
        for (Player p : finnishPlayers) {
            System.out.println(p.toPointString());
        }
    }
}
