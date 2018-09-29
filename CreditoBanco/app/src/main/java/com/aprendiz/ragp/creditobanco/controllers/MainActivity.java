package com.aprendiz.ragp.creditobanco.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.aprendiz.ragp.creditobanco.R;
import com.aprendiz.ragp.creditobanco.models.Cliente;
import com.aprendiz.ragp.creditobanco.models.ManagerDB;
import com.aprendiz.ragp.creditobanco.models.Modulo;
import com.aprendiz.ragp.creditobanco.models.Solicitud;
import com.aprendiz.ragp.creditobanco.models.Tapizar;
import com.aprendiz.ragp.creditobanco.models.Tasa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Modulo> moduloList = new ArrayList<>();
    List<Solicitud> solicitudList = new ArrayList<>();
    List<Tapizar> tapizarList = new ArrayList<>();
    List<Tasa> tasaList = new ArrayList<>();
    List<Cliente> clienteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            inputDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void inputDataBase() throws IOException {
        ManagerDB managerDB = new ManagerDB(this);
        List<Cliente> clientes  = managerDB.selectCliente();
        if (clientes.size()<1){
            Modulo modulo = new Modulo();
            Solicitud solicitud = new Solicitud();
            Cliente cliente = new Cliente();
            Tapizar tapizar = new Tapizar();
            Tasa tasa = new Tasa();
            String linea;
            InputStream is = getResources().openRawResource(R.raw.creditobanco);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            if (is!=null){
                while ((linea=reader.readLine())!=null){
                    String [] strings = linea.split(";");
                    if (strings[0].length()>0){
                        modulo.setId(Integer.parseInt(strings[0]));
                        modulo.setNombre(strings[1]);
                        managerDB.inputModulo(modulo);
                    }

                    if (strings[3].length()>0){
                        solicitud.setId(Integer.parseInt(strings[3]));
                        solicitud.setNombre(strings[4]);
                        solicitud.setModulo(Integer.parseInt(strings[5]));
                        managerDB.inputSolicitud(solicitud);
                    }

                    if (strings[7].length()>0){
                        cliente.setId(Integer.parseInt(strings[7]));
                        cliente.setNombre(strings[8]);
                        managerDB.inputCliente(cliente);
                    }

                    if (strings[10].length()>0){
                        tasa.setrTapizar(Integer.parseInt(strings[10]));
                        tasa.setTamano(Integer.parseInt(strings[11]));
                        tasa.setTasaTa(Float.parseFloat(strings[12]));
                        managerDB.inputTasa(tasa);
                    }


                    if (strings[14].length()>0){
                        tapizar.setId(Integer.parseInt(strings[14]));
                        tapizar.setSolicitud(Integer.parseInt(strings[15]));
                        tapizar.setCliente(Integer.parseInt(strings[16]));
                        tapizar.setRetorno(Integer.parseInt(strings[17]));
                        managerDB.inputTapizar(tapizar);
                    }

                }
            }
            Toast.makeText(this, "Hecho", Toast.LENGTH_SHORT).show();
        }

    }


}
