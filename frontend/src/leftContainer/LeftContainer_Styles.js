import makeStyles from "@material-ui/core/styles/makeStyles";

const useStyles = makeStyles(theme => ({
    MainImage: {
        backgroundImage: `url(/assets/images/index_image.jpg)`, 
        backgroundSize: 'cover',
        backgroundPosition: 'center'
    }
}));

export default useStyles;