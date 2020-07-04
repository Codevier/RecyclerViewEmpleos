package com.example.recyclerviewempleos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.recyclerviewempleos.Adapter.AdaptadorRecyclerEmpleo;
import com.example.recyclerviewempleos.Model.Empleo;
import com.example.recyclerviewempleos.WebService.Asynchtask;
import com.example.recyclerviewempleos.WebService.WebService;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity  implements Asynchtask
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View header = getLayoutInflater().inflate(R.layout.ly_header, null);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://api.jsonbin.io/b/5efe857d0bab551d2b6af8b1",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Empleo> lstEmpleados = new ArrayList<Empleo> ();

        try {
            JSONArray JSONlista =  new JSONArray(result);
            lstEmpleados = Empleo.JsonObjectsBuild(JSONlista);
            RecyclerView recyclerView;
            recyclerView=(RecyclerView) findViewById(R.id.lstListaUsuario);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            AdaptadorRecyclerEmpleo adaptadorRecycler=new AdaptadorRecyclerEmpleo(lstEmpleados);
            recyclerView.setAdapter(adaptadorRecycler);

        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }


    }
}