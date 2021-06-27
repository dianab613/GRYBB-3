package diproj.signups.resources.tools;
import org.springframework.security.crypto.bcrypt.BCrypt;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public Hash(){

    }
    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0;i<digest.length;i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        String hashed = hexString.toString();
        return hashed;

    }
    public boolean matchPass(String plaintext, String hashpass) throws NoSuchAlgorithmException {
        Hash hash = new Hash();
        if (hash.hashPassword(plaintext).equals(hashpass)){
            return true;
        }
        else{
            return false;
        }
    }
}
