package br.eti.gadelha.exception.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public enum EnumTypePlatform {
    ANEMOGRAFO("Anemógrafo"),
    ANEMOMETRO("Anemômetro"),
    BAROGRAFO("Barógrafo"),
    BAROMETRO("Barômetro"),
    CATAVENTO("Catavento"),
    EVAPORIMETRO_DE_PINCHE("Evaporímetro de Piche"),
    HELIOGRAFO("Heliógrafo"),
    HIDROGRAFO("Hidrógrafo"),
    PLUVIOGRAFO("Pluviógrafo"),
    PLUVIOMETRO("Pluviômetro"),
    PSICROMETRO("Psicrômetro"),
    TERMOGRAFO("Termógrafo"),
    TERMOHIGROGRAFO("Termohigrógrafo"),
    TERMOMETRO_DE_MAXIMA("Termômetro_de_máxima"),
    TERMOMETRO_DE_MINIMA("Termômetro de mínima"),
    TERMOMETRO_DE_SOLO("Termômetros de solo");

    private final String name;
}
