<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/users">
        <table border="1">
            <tr><td>name</td><td>nick</td><td>phone</td><td>address</td><td>pk</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/users/user">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/users/user/name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/nick">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/telephone">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/adres">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad">
        <td><xsl:apply-templates/></td>
    </xsl:template>


</xsl:stylesheet>