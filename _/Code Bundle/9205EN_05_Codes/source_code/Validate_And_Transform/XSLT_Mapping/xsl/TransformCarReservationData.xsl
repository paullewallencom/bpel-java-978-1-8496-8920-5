<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="XSD">
      <schema location="../xsd/TempSchema.xsd"/>
      <rootElement name="TempElement" namespace="http://org.packt.temp"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../XML_Mapping.wsdl"/>
      <rootElement name="processResponse" namespace="http://xmlns.oracle.com/Validate_And_Transform/XSLT_Mapping/XML_Mapping"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.6.0(build 111214.0600.1553) AT [THU MAR 28 14:46:10 CET 2013]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:client="http://xmlns.oracle.com/Validate_And_Transform/XSLT_Mapping/XML_Mapping"
                xmlns:ns0="http://org.packt.temp"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:bpel="http://docs.oasis-open.org/wsbpel/2.0/process/executable"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:plnk="http://docs.oasis-open.org/wsbpel/2.0/plnktype"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:ud="http://www.oracle.com/XSL/Transform/java/org.packt.user.defined.ValueWithUnit"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl ns0 xsd client plnk wsdl bpws xp20 mhdr bpel oraext dvm hwf med ids bpm xdk xref ora socket ud ldap">
  <xsl:template match="/">
    <client:processResponse>
      <client:carBrand>
        <xsl:value-of select="/ns0:TempElement/ns0:pieces[1]"/>
      </client:carBrand>
      <client:year>
        <xsl:value-of select="/ns0:TempElement/ns0:pieces[2]"/>
      </client:year>
      <client:milleage>
        <xsl:value-of select="ud:formatValueWithUnit(/ns0:TempElement/ns0:pieces[3],/ns0:TempElement/ns0:pieces[4])"/>
      </client:milleage>
      <client:price>
        <xsl:value-of select="concat(/ns0:TempElement/ns0:pieces[5] * 1.05,/ns0:TempElement/ns0:pieces[6])"/>
      </client:price>
      <client:ref>
        <xsl:value-of select="/ns0:TempElement/ns0:pieces[7]"/>
      </client:ref>
    </client:processResponse>
  </xsl:template>
</xsl:stylesheet>