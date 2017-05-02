package gov.cms.qpp.acceptance;

import gov.cms.qpp.conversion.Converter;
import gov.cms.qpp.conversion.TransformationStatus;
import gov.cms.qpp.util.JsonHelper;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class QualityMeasureIdRoundTripTest {
	public static final Path JUNK_QRDA3_FILE = Paths.get("src/test/resources/negative/junk_in_quality_measure.xml");

	@Test
	public void testRoundTripForQualityMeasureId() throws IOException {
		Converter converter = new Converter(JUNK_QRDA3_FILE);
		TransformationStatus transformStatus = converter.transform();

		assertThat("Converting the junk QRDA3 file should have been successful.", transformStatus,
			is(TransformationStatus.SUCCESS));

		Map<String, ?> qppJson = JsonHelper.readJson("junk_in_quality_measure.qpp.json", Map.class);
	}
}
