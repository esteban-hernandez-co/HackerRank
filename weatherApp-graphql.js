Initialize a new Node.js project:

bash
Copy code
mkdir graphql-weather-api
cd graphql-weather-api
npm init -y
Install dependencies:

Install the necessary packages:

bash
Copy code
npm install express apollo-server-express axios
Create a GraphQL schema:

Create a file named schema.graphql with the following content:

graphql
Copy code
type Weather {
  temperature: Float
  description: String
}

type Query {
  getWeather(city: String!): Weather
}
Create a GraphQL server:

Create a file named server.js:

javascript
Copy code
const express = require('express');
const { ApolloServer, gql } = require('apollo-server-express');
const axios = require('axios');

const typeDefs = gql`
  type Weather {
    temperature: Float
    description: String
  }

  type Query {
    getWeather(city: String!): Weather
  }
`;

const resolvers = {
  Query: {
    getWeather: async (_, { city }) => {
      try {
        const response = await axios.get('http://api.openweathermap.org/data/2.5/weather', {
          params: {
            q: city,
            appid: 'your_openweathermap_api_key',
            units: 'metric', // You can change the units as needed
          },
        });

        const weatherData = response.data;
        return {
          temperature: weatherData.main.temp,
          description: weatherData.weather[0].description,
        };
      } catch (error) {
        console.error('Error fetching weather data:', error);
        throw new Error('Failed to fetch weather data');
      }
    },
  },
};

const server = new ApolloServer({ typeDefs, resolvers });
const app = express();
server.applyMiddleware({ app });

const PORT = 4000;
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}${server.graphqlPath}`);
});
Replace 'your_openweathermap_api_key' with your actual OpenWeatherMap API key.

Run the server:

bash
Copy code
node server.js
Your GraphQL server should now be running at http://localhost:4000/graphql.

Test the GraphQL API:

Open your browser or a tool like GraphQL Playground and navigate to http://localhost:4000/graphql. You can test the getWeather query:

graphql
Copy code
query {
  getWeather(city: "London") {
    temperature
    description
  }
}
You should receive weather data for London in the specified format.