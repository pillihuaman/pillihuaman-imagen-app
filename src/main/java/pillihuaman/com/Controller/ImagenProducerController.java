package pillihuaman.com.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pillihuaman.com.Help.Constants;
import pillihuaman.com.Service.ImagenService;
import pillihuaman.com.base.response.RespBase;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;
import java.io.IOException;

@RestController
@Tag(name = "Imagen", description = "")

public class ImagenProducerController {
	@Autowired
	private ImagenService imagenService;
	@Autowired(required = false)
	protected final Log log = LogFactory.getLog(getClass());

	@Operation(summary = "get  imagen", description = "get  imagen", tags = { "" }, security = {
			@SecurityRequirement(name = Constants.BEARER_JWT) })
	@ApiResponses(value = {
			@ApiResponse(responseCode = Constants.SERVER_200, description = Constants.OPERACION_EXITOSA),
			@ApiResponse(responseCode = Constants.SERVER_400, description = Constants.ERROR_VALIDACION, content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RespBase.class)) }),
			@ApiResponse(responseCode = Constants.SERVER_500, description = Constants.ERROR_INTERNO, content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RespBase.class)) }) })
	@GetMapping(path = { Constants.BASE_ENDPOINT_IMAGEN + "/imagen/getImagen" }, produces = {
			MediaType.IMAGE_JPEG_VALUE })
	public ResponseEntity<byte[]> GetImagen(@QueryParam("codImagen") String codImagen, HttpServletResponse response)
			throws IOException {
		byte[] img = imagenService.getImagen(codImagen);
		if (img != null) {
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
		}
		{
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(null);

		}
	}

}
// FileInputStream fis = new FileInputStream(new File("some_path/test.jpeg"));
