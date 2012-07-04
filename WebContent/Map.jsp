<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://code.google.com/p/gmaps4jsf/" prefix="m" %>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script

src="http://maps.google.com/maps?file=api&amp;v=2&amp;
key=ABQIAAAAxrVS1QxlpJHXxQ2Vxg2bJBT2yXp_ZAY8_ufC3CFXhHIE1NvwkxS9AOPy_YJl48ifAy4mq6I8SgK8fg"
type="text/javascript">

</script>     
</head>

<body onunload="GUnload()">
	<f:view>
		<h:form id="form">
			<m:map width="500px" latitude="48.833" longitude="2.333" height="500px"
				zoom="12" autoReshape="true">
				<a4j:repeat var="station"
					value="#{mapPointLocationBean.mapliste}">
	                        <m:marker latitude="#{station.latitude}" longitude="#{station.longitude}">
	                            <m:htmlInformationWindow htmlText="<b>#{station.latitude}-#{station.longitude}</b>" />
	                        </m:marker>
				</a4j:repeat>
			</m:map>
		</h:form>
	</f:view>
</body>

</html>