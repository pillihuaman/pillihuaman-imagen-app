package pillihuaman.com.Service.Implement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pillihuaman.com.Service.ImagenService;
import pillihuaman.com.basebd.imagenProducer.domain.dao.ImagenProducerDAO;

@Component
public class ImagenServiceImpl implements ImagenService {
	@Autowired
	private ImagenProducerDAO imagenProducerDAO;
	@Autowired(required = false)
	protected final Log log = LogFactory.getLog(getClass());

	@Override
	public byte[] getImagen(String codImagen) {
		byte[] imgArra = imagenProducerDAO.getImagenInputStream(codImagen);
		return imgArra;
	}

}
