package com.mycode.pi_dam2_davidjuan;

import java.util.ArrayList;

public class Datos {
    ArrayList<ItemLista> lista;
    public Datos() {
        lista = new ArrayList<ItemLista>();
        lista.add(new ItemLista(R.drawable.ic_launcher_background, "BUHO",
                "Búho es el nombre común de aves de la familia Strigidae, del orden de las estrigiformes o aves rapaces nocturnas. Habitualmente designa especies que, a diferencia de las lechuzas, tienen plumas alzadas que parecen orejas."));
        lista.add(new ItemLista(R.drawable.ic_launcher_background, "PINGÜINO",
                "Los pingüinos (familia Spheniscidae, orden Sphenisciformes) son un grupo de aves marinas, no voladoras, que se distribuyen únicamente en el Hemisferio Sur, sobre todo en sus altas latitudes."));
        lista.add(new ItemLista(R.drawable.ic_launcher_background, "COLIBRÍ",
                "Los troquilinos (Trochilinae) son una subfamilia de aves apodiformes de la familia Trochilidae, " +
                        "conocidas vulgarmente como colibríes, quindes, tucusitos, picaflores, chupamirtos, chuparrosas, " +
                        "huichichiquis (idioma nahuatl), mainumby (idioma guaraní) o guanumby. Conjuntamente con las ermitas, " +
                        "que pertenecen a la subfamilia Phaethornithinae, conforman la familia Trochilidae que, en la sistemática de Charles Sibley," +
                        " se clasifica en un orden propio: Trochiliformes, independiente de los vencejos del orden Apodiformes." +
                        " La subfamilia Trochilinae incluye más de 100 géneros que comprenden un total de 330 a 340 especies."));
        lista.add(new ItemLista(R.drawable.ic_launcher_background, "CUERVO",
                "El cuervo común (Corvus corax) es una especie de ave paseriforme de la familia " +
                        "de los córvidos (Corvidae). Presente en todo el hemisferio septentrional, es la especie de córvido con la mayor superficie de distribución. Con el cuervo de pico grueso, es el mayor de los córvidos y probablemente la paseriforme más pesada; " +
                        "en su madurez, el cuervo común mide entre 52 y 69 centímetros de longitud y su peso varía de 0,69 a 1,7 kilogramos. " +
                        "Los cuervos comunes viven generalmente de 10 a 15 años pero algunos individuos han vivido 40 años. Los juveniles pueden desplazarse en grupos pero las parejas ya formadas permanecen juntas toda su vida, cada pareja defendiendo un territorio. " +
                        "Existen 8 subespecies conocidas que se diferencian muy poco aparentemente, aunque estudios recientes hayan demostrado diferencias genéticas significativas entre las poblaciones de distintas regiones."));
        lista.add(new ItemLista(R.drawable.ic_launcher_background, "PAVO",
                "Pavo es un género de aves galliformes de la familia Phasianidae, que incluye dos especies, el pavo real común (Pavo cristatus)"));
        lista.add(new ItemLista(R.drawable.ic_launcher_background, "FLAMENCO", "Los fenicopteriformes (Phoenicopteriformes), los cuales reciben el nombre vulgar de flamencos, son un orden de aves neognatas, con un único género viviente: " +
                "Phoenicopterus. Son aves que se distribuyen tanto por el hemisferio occidental como por el hemisferio oriental: existen cuatro especies en América y dos en el Viejo Mundo. Tienen cráneo desmognato holorrino, con 16 a 20 vértebras cervicales y pies anisodáctilos."));
        lista.add(new ItemLista(R.drawable.ic_launcher_background, "KIWI", "Los kiwis (Apterix, gr. 'sin alas') son un género de aves paleognatas compuesto por cinco especies endémicas de Nueva Zelanda.1 2 Son aves no voladoras pequeñas," +
                " aproximadamente del tamaño de una gallina. Antes de la llegada de los humanos alrededor del año 1300, en Nueva Zelanda los únicos mamíferos que había eran murciélagos, y los nichos ecológicos que en otras partes del mundo eran ocupados por animales tan diversos como caballos," +
                " lobos y ratones fueron utilizados en Nueva Zelanda por pájaros (y en menor proporción por ciertas especies de reptiles). La denominación kiwi es maorí, idioma del pueblo homónimo de linaje malayopolinesio que colonizó Nueva Zelanda antes de la llegada de los europeos."));
        lista.add(new ItemLista(R.drawable.ic_launcher_background, "LORO", "Las Psitácidas (Psittacidae) son una familia de aves psitaciformes llamadas comúnmente loros o papagayos, e incluye a los guacamayos, las cotorras, los periquitos, los agapornis y formas afines."));
    }
    public ArrayList<ItemLista> getLista() {
        return lista;
    }
}