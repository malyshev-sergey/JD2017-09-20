<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/claim">
    <html>
        <table border="1">
            <tr>
                <th> Name</th>
                <th> Email</th>
                <th> TelNumber</th>
                <th> TourName</th>
            </tr>
            <xsl:for-each select="client">
                    <tr>
                        <th><xsl:value-of select="name"/></th>
                        <th><xsl:value-of select="email"/></th>
                        <th><xsl:value-of select="telNumber"/></th>
                        <th><xsl:value-of select="tourName"/></th>
                    </tr>
            </xsl:for-each>
        </table>
    </html>
    </xsl:template>
</xsl:stylesheet>