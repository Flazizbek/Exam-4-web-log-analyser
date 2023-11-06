import java.io.*;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Main {

    public static void main(String[] args) throws IOException {


        ArrayList<String> info = new ArrayList<>();
        ArrayList<String> IP_adress = new ArrayList<>();
        ArrayList<String> userName = new ArrayList<>();
        ArrayList<String> time = new ArrayList<>();
        ArrayList<String> url = new ArrayList<>();
        ArrayList<String> code = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("src/access.txt"));
        String line = br.readLine();
        while (line != null) {
            info.add(line);
            line = br.readLine();
        }
        for (int i = 0; i < info.size(); i++) {
            Pattern IP_pattern = Pattern.compile("^(\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])");
            Matcher matcher1 = IP_pattern.matcher(info.get(i));
            if (matcher1.find()) {
                IP_adress.add(matcher1.group());
            }
            Pattern userNamePattern = Pattern.compile("\\[(([a-z]+_\\w+)|([a-z]+\\d+))\\]");
            Matcher matcher2 = userNamePattern.matcher(info.get(i));
            if (matcher2.find()) {
                userName.add(matcher2.group());
            }
            Pattern timePattern = Pattern.compile("\\[(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})\\]");
            Matcher matcher3 = timePattern.matcher(info.get(i));
            if (matcher3.find()) {
                time.add(matcher3.group());
            }
            Pattern urlPattern = Pattern.compile("(//?(/[a-z]+)/[a-z]+)|(/[a-z]+/[a-z]+.[a-z]+)|(/[a-z]+)");
            Matcher matcher4 = urlPattern.matcher(info.get(i));
            if (matcher4.find()) {
                url.add(matcher4.group());
            }
            Pattern codePattern = Pattern.compile(" \\d{3}");
            Matcher matcher5 = codePattern.matcher(info.get(i));
            if (matcher5.find()) {
                code.add(matcher5.group());
            }
        }

    }
}