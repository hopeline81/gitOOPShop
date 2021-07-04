package data;

import java.util.ArrayList;

public interface OnEventListener {

    void onRead(ArrayList<String> resultEmployeesData);

    void onWrite();
}
