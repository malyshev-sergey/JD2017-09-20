<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/ShoppingCenters">
        <head/>
        <body>
            <table border="1">
                <tr>
                    <td>
                        Name
                    </td>
                    <td>
                        Adress
                    </td>
                    <td>
                        Lat
                    </td>
                    <td>
                        Lng
                    </td>
                    <td>
                        Room
                    </td>
                </tr>
                <xsl:apply-templates/>
            </table>
        </body>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Name">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Address">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Address/Country">
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Address/City">
        город:
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Address/Street">
        ,
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Lat">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Lng">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Rooms">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Rooms/Room">
        <xsl:apply-templates/>
        <hr/>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Rooms/Room/RoomName">
        Помещение:
        <xsl:apply-templates/>
        <br/>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Rooms/Room/Square">
        Площадь, м2:
        <xsl:apply-templates/>
        <br/>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Rooms/Room/Price">
        Аренда, $:
        <xsl:apply-templates/>
        <br/>
    </xsl:template>
    <xsl:template match="ShoppingCenters/ShoppingCenter/Rooms/Room/isRented">
        Арендовано:
        <xsl:apply-templates/>
        <br/>
    </xsl:template>
</xsl:stylesheet>