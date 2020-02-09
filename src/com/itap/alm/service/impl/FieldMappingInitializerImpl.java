package com.itap.alm.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itap.alm.beans.ExcelMappingDO;
import com.itap.alm.service.FieldMappingInitializer;

import jxl.Workbook;

@Component("fieldMappingInitializer")
public class FieldMappingInitializerImpl implements FieldMappingInitializer{

	private static String STATIC_FIELD_MAPPING_TAB = "StaticFiedlMappings";
	private static String DYNAMIC_FIELD_MAPPING_TAB = "DynamicFieldMappings";

	public HashMap<String, String> getStaticFiedlMappingsFromExcel(final String xmlMappingFilePath) {
		final HashMap<String, String> staticFiedlMapping = new HashMap<String, String>();
		try {

			final File mappingFile = new File(xmlMappingFilePath);
			if (mappingFile != null) {
				final jxl.Workbook workBook = jxl.Workbook.getWorkbook(mappingFile);
				final jxl.Sheet sheet = workBook.getSheet(STATIC_FIELD_MAPPING_TAB);
				final int numberOfRows = sheet.getRows();
				for (int rowCounter = 1; rowCounter < numberOfRows; rowCounter++) {
					final String fieldName = sheet.getCell(0, rowCounter).getContents().trim();
					final String fieldValue = sheet.getCell(1, rowCounter).getContents().trim();
					if (fieldName != null && fieldName.length() > 0) {
						staticFiedlMapping.put(fieldName, fieldValue);
					}
				}
			}
			return staticFiedlMapping;
		} catch (final Exception e) {
			return null;
		}
	}

	public List<ExcelMappingDO> getDynamicFieldMappingsFromExcel(final String xmlMappingFilePath, final String projectName) {
		final List<ExcelMappingDO> excelMappingDOList = new ArrayList<ExcelMappingDO>();
		try {
			final File mappingFile = new File(xmlMappingFilePath);

			if (mappingFile != null) {
				final Workbook workBook = Workbook.getWorkbook(mappingFile);
				final jxl.Sheet sheet = workBook.getSheet(DYNAMIC_FIELD_MAPPING_TAB);
				final int numberOfRows = sheet.getRows();
				for (int rowCounter = 1; rowCounter < numberOfRows; rowCounter++) {
					final ExcelMappingDO excelMappingDO = new ExcelMappingDO();
					final String thisProjectName = sheet.getCell(0, rowCounter).getContents().trim();
					if (thisProjectName.equals(projectName)) {
						final String xmlFieldName = sheet.getCell(1, rowCounter).getContents().trim();
						final String almFieldName = sheet.getCell(2, rowCounter).getContents().trim();
						final String fieldType = sheet.getCell(3, rowCounter).getContents().trim();
						excelMappingDO.setProjectName(thisProjectName);
						excelMappingDO.setFieldScopeType(fieldType);
						excelMappingDO.setAlmFieldName(almFieldName);
						excelMappingDO.setXmlFieldName(xmlFieldName);
						excelMappingDOList.add(excelMappingDO);
					}
				}
			}
			return excelMappingDOList;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
