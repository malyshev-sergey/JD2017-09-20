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
            <th>Тема</th>
            <tr>
                <td>
                    <xsl:apply-templates/>
                </td>
            </tr>
        </table>
    </xsl:template>
    <xsl:template match="Tickets/Ticket">
        <br/>
        <table border="1">
            <th colspan="4">
                Билет
            </th>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="Tickets/Ticket/Question">
        <tr>
            <td colspan="4">
                <xsl:apply-templates/>
            </td>
        </tr>
    </xsl:template>
    <xsl:template match="Tickets/Ticket/Answers">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="Tickets/Ticket/Answers/Answer">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>