<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="Tickets">
        <head/>
        <body>
            <xsl:apply-templates/>
        </body>
    </xsl:template>

    <xsl:template match="Tickets/Header">
        <table border="1">
            <tr>
                <td>Тема</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
</xsl:stylesheet>