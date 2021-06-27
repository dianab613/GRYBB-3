package diproj.signups.resources.tools;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Hash {

    public Hash(){

    }
    public String hashPassword(String password){
        String hashed = BCrypt.hashpw(password,BCrypt.gensalt(12));
        return hashed;
    }
    public boolean matchPass(String plaintext, String hashpass){
        if (BCrypt.checkpw(plaintext, hashpass))
            return true;
        else
            return false;
    }
}
