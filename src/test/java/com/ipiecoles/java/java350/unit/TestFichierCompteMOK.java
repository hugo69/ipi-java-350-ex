package com.ipiecoles.java.java350.unit;

import com.ipiecoles.java.java350.FichierCompte;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import static org.mockito.Mockito.mock;

/**
 * Created by HCHARBONNEYR on 06/11/2017.
 */
public class TestFichierCompteMOK {
    @Test
    public void testouverture() throws Exception {
        //Given
        FileInputStream fileStream = mock(FileInputStream.class);
        ObjectInputStream objecStream= mock(ObjectInputStream.class);
        PowerMockito.whenNew(FileInputStream.class).withAnyArguments().thenReturn(fileStream);
        PowerMockito.whenNew(ObjectInputStream.class).withAnyArguments().thenReturn(objecStream);
        FichierCompte fichierCompte = new FichierCompte();

        //Then
        boolean ouvert = fichierCompte.ouvrir("R");

        //Then
        Assertions.assertThat(ouvert).isTrue();
        Assertions.assertThat(fichierCompte.getfRo()).isNull();

    }
}
