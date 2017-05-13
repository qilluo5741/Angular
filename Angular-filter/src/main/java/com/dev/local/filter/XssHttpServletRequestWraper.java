package com.dev.local.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWraper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWraper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		return clearXss(super.getParameter(name));
	}

	@Override
	public String getHeader(String name) {
		return clearXss(super.getHeader(name));
	}

	@Override
	public String[] getParameterValues(String name) {
		// Get the full value
		String[] values = super.getParameterValues(name);
		// Re-initialize a value
		String[] newValues = null;
		try {
			newValues = new String[values.length];
			for (int i = 0; i < values.length; i++) {
				// Replace the assignment again
				newValues[i] = clearXss(values[i]);
			}
		} catch (Exception e) {
			System.out.println("This error is normal！");
		}
		return super.getParameterValues(name);
	}

	/***
	 * @param value
	 * @return
	 */
	private String clearXss(String value) {
		if (value == null || "".equals(value)) {
			return value;
		}
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("'", "&#39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("script", "");
		value = value.replaceAll("update", "");
		value = value.replaceAll("delect", "");
		return value;
	}
}