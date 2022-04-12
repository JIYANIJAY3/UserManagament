package bean;

import java.io.InputStream;

public class UserProfileBean {
	private int UserId;
	private int ImageId;
	private String base64Image;
	private InputStream Image;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getImageId() {
		return ImageId;
	}

	public void setImageId(int imageId) {
		ImageId = imageId;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public InputStream getImage() {
		return Image;
	}

	public void setImage(InputStream image) {
		Image = image;
	}

}
