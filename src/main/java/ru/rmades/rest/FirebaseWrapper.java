package ru.rmades.rest;

/**
 * Created by Администратор on 23.08.2016.
 */


import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;



public class FirebaseWrapper {

    private FirebaseOptions options;
    public FirebaseWrapper(){
        try {
            options = new FirebaseOptions.Builder()
                    //.setServiceAccount(new FileInputStream("C:\\Users\\Администратор\\IdeaProjects\\SN-Munchkin-server\\src\\main\\java\\ru\\rmades\\rest\\SN-Munchkin-d4644b794e33.json"))
                    .setServiceAccount(IOUtils.toInputStream(serviceAcc))
                    .setDatabaseUrl("https://sn-munchkin.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
            System.out.println("Firebase is build");
        }catch (Exception e){
            System.out.println("Error: " + e.toString());
        }
    }
    private static final String serviceAcc = "{\n" +
            "  \"type\": \"service_account\",\n" +
            "  \"project_id\": \"sn-munchkin\",\n" +
            "  \"private_key_id\": \"d4644b794e33e037a792fc10c28a73a463dc416e\",\n" +
            "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCmg2/C0rfVhefG\\nP11EYWZwJu2UTRLuJei2kuXapjf1b5SeqWVc+NH3smMGs6ZCWid5upH9OWG2TJJb\\ntCBeJOPDhakQemKL/SKjCzhD+1XaolKwRB6YMS21ahU1FZeHZPGRSJfdwwtGMWOd\\nd1+YxWPYarTvq+Vm3rT2zJxysIAlqVXUcMZ3LnN5qqN5+iDR4R40STs/qEbVYSpj\\npi8WrSzrhyL+DwAnxXiAOOwHQO+Do0g6DujaO67xzeMqDRHxyCGAajlIzoJNTJUG\\n2NjBpRW0f81iZoXHsCdRUI5cLTWVqhygB6E3Wsij6SnHXFQATX0ELvcdN+I3JB86\\n+tM5xxzZAgMBAAECggEAQslJFE1MKrpQojVcBUdDvQwAEpFvXFGcK050HuS4YRrl\\n81ViMI4kOUM1cMSxlL9wQeTRFU3koSfJNDrlGJ2XNR7xFojf6eIX+GlRogK3BsBA\\nhi5sTwK6oJ7x7p7Abi/QrEL/lpTaesboe4obr7zMNUtnUxIRKtd8odijj2S3oWLK\\nOicTXmJSDMmnzEvOrJoESNzbwk3tsuxmozGkwg08XIUBgGSDU0mTY/SB1aFS8B9z\\n7Exs7TAG31KoAK4zPhRVtmgzDoKIXFRqIG4KElYKmHvZXd+oLoD6fhlI0EV1eF5p\\nkWEZaI/UAeEPnjSeEsEoDb7Zs2sEOU/W4sm36ytk4QKBgQDT+M8lOYXi1B0wQaMW\\nB0JZLw35uHtToTDvxcrEVnquhVo65zfeVNBPqjdKaLgmZ8ujru4n0+62QFSA0RgA\\nxMycAJ3sFJZXjmvq+FoALOCm/Pnkm7exn5FPF9nmNNOAz3fRCXaVCuEFdIIIBeov\\nyem9FwYhEFZmW/tlpIU5QOrBZQKBgQDJGXYj2K/xZyDVs5nXqFoA4yw2ffwoT+yW\\nAvcEkmeHSJMvhWXKx1ILMeehU2VtaVd6C3cljfm4wM7XR9qE7lhgGBkH5OimK2vU\\nm6G+7MSeQff+YUUt4/mXx9SrI1/OJ+FJY5//wAKDJOnLpnxnVwXbjpW0T8zmJQTs\\nII2IeOCQZQKBgQCS8PzwCiNE7dPaGvYqFBgraNIgVYGwpKIe5Rc96dEb4Dd/c7+n\\n8VWClDXF8DgP744cRuyzUVg+oPOzZL9l8QcB8e+Hs3HQ+lrXRRhm3LVTLTUyA7xg\\ndoQttxQHYIFp3uhpUU0R3rvEo1Jsq2T/gdH1kdte2kt6o7LvcBAmc1kJfQKBgC6x\\nc8X0/T1PFceo8RKq62MDXHO2owL1M9jNDXAJUnKN/mbtUWpZB4rD5qWFyKoz6HTV\\nDrAwnAgy9JP2Ah4VfX2qer1jgEV9FYeDL3Y2YZzhcmSlTzvNkFmWs6GdEBS9G8k/\\nkZn/ilXLD2IS4RXZlemZ3NbGJKxXciIlmNdUQcglAoGBALzTJra3taTolo6j5E+M\\n5NbxFwUfc8eqtXAgAmbXqwAhTKZmp72K7awQc4lIi9hvtfksY/+bNVVZvyJa0zms\\n/yqz0bqDlh+yCN6gtQnnzRQGF2LeYk621GmXKZIOX9j+0XEBXxznPUS4XirpzqYT\\nsNmG9WXyRU3U9QVcZsJczZBw\\n-----END PRIVATE KEY-----\\n\",\n" +
            "  \"client_email\": \"leovs09@sn-munchkin.iam.gserviceaccount.com\",\n" +
            "  \"client_id\": \"112090598236284234019\",\n" +
            "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
            "  \"token_uri\": \"https://accounts.google.com/o/oauth2/token\",\n" +
            "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
            "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/leovs09%40sn-munchkin.iam.gserviceaccount.com\"\n" +
            "}";

}
