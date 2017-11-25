<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/Gendata">
        <xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
        <html>
            <head>
                <link rel="stylesheet" href="style.css" type="text/css"/>

            </head>
            <body>
                <table>
                    <tr class="tab">
                        <td rowspan="3">
                            Kit
                        </td>

                        <td rowspan="3">
                            Name
                        </td>
                        <td rowspan="3">
                            Ancestor
                        </td>
                        <td rowspan="3">
                            Country
                        </td>
                        <td colspan="2">
                            Geocoord
                        </td>
                        <td colspan="13">
                            Haplotype
                        </td>
                    </tr>
                    <tr>
                        <td class="tab" rowspan="2">
                            Latitude
                        </td>
                        <td class="tab" rowspan="2">
                            Longitude
                        </td>
                        <td class="STRs" colspan="12">
                            STR markers
                        </td>
                        <td class="SNPs" rowspan="2">
                            SNPs
                        </td>
                    </tr>
                    <tr class="STR">
                        <td>DYS393</td>
                        <td>DYS390</td>
                        <td>DYS19</td>
                        <td>DYS391</td>
                        <td>DYS385a</td>
                        <td>DYS385b</td>
                        <td>DYS426</td>
                        <td>DYS388</td>
                        <td>DYS439</td>
                        <td>DYS389i</td>
                        <td>DYS392</td>
                        <td>DYS389ii</td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="Gendata/Person">
        <tr class="pers">
            <td><strong>
                <xsl:value-of select="@kit"/>
            </strong></td>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="Gendata/Person/Name">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="Gendata/Person/Ancestor">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="Gendata/Person/Country">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="Gendata/Person/Geocoord">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="Gendata/Person/Geocoord/Latitude">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="Gendata/Person/Geocoord/Longitude">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="Gendata/Person/Haplotype/STRmarkers">
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS393">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS390">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS19">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS391">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS385a">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS385b">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS426">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS388">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS439">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS389i">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS392">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/STRmarkers/DYS389ii">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="Gendata/Person/Haplotype/SNPs">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>