package com.ikubinfo.project.presentation.converters;

//Custom Converter
//Default Converters
//BigDecimalConverter
//BigIntegerConverter
//BooleanConverter
//ByteConverter
//CharacterConverter
//DateTimeConverter
//DoubleConverter
//FloatConverter
//IntegerConverter
//LongConverter
//NumberConverter
//ShortConverter
//<f:convertDateTime pattern="d-M-yyyy" />
//</h:inputText>

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ikubinfo.project.entity.Aim;
import com.ikubinfo.project.presentation.controllers.AimsController;

@FacesConverter(forClass = Aim.class)
public class AimsConverter implements Converter {
	private static final Logger LOG = LogManager.getLogger(AimsConverter.class);

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		AimsController controller = (AimsController) facesContext
				.getApplication().getELResolver()
				.getValue(facesContext.getELContext(), null, "aimsController");
		return controller.getAims(getKey(value));
	}

	java.lang.Integer getKey(String value) {
		java.lang.Integer key;
		key = Integer.valueOf(value);
		return key;
	}

	String getStringKey(java.lang.Integer value) {
		StringBuilder sb = new StringBuilder();
		sb.append(value);
		return sb.toString();
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof Aim) {
			Aim o = (Aim) object;
			return getStringKey(o.getId());
		} else {
			LOG.error("object {0} is of type {1}; expected type: {2}",
					new Object[] { object, object.getClass().getName(),
							Aim.class.getName() });
			return null;
		}
	}

}