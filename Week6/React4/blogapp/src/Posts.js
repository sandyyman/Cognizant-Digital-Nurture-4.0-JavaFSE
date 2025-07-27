class Posts extends React.Component{
    constructor(props) {
        super(props);
    }

    loadPosts() {

        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                // Handle the loaded posts
                console.log(data);
            });
    }

    componentDidMount() {
        this.loadPosts();
    }
    render() {
        return (
            <div>
                <h1>Posts</h1>
                {/* Render posts here */}
            </div>
        );
    }
}
export default Posts;